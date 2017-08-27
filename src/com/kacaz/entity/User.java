package com.kacaz.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class User {

	private int id;
	private Username username;
	private String nickname;
	private String photo;
	private Set<User> followings;
	private Set<User> followers;
	private Set<Work> works;
	private Set<Activity> heldActivities;
	private Set<Activity> participatedActivities;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@OneToOne(mappedBy="user",cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
	public Username getUsername() {
		return username;
	}
	public void setUsername(Username username) {
		this.username = username;
	}
	
	@Column(length = 30)
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	@ManyToMany(cascade={CascadeType.MERGE, CascadeType.PERSIST}, fetch=FetchType.LAZY) 
	@JoinTable(name="fans_hosts", joinColumns={@JoinColumn(name="fans", referencedColumnName="id")}, inverseJoinColumns={@JoinColumn(name="hosts", referencedColumnName="id")})
	public Set<User> getFollowings() {
		return followings;
	}
	public void setFollowings(Set<User> followings) {
		this.followings = followings;
	}
	
	@ManyToMany(cascade={CascadeType.MERGE, CascadeType.PERSIST}, fetch=FetchType.LAZY, mappedBy="followings")
	public Set<User> getFollowers() {
		return followers;
	}
	public void setFollowers(Set<User> followers) {
		this.followers = followers;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "owner")
	public Set<Work> getWorks() {
		return works;
	}
	public void setWorks(Set<Work> works) {
		this.works = works;
	}
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "promoter")
	public Set<Activity> getHeldActivities() {
		return heldActivities;
	}
	public void setHeldActivities(Set<Activity> heldActivities) {
		this.heldActivities = heldActivities;
	}
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.LAZY)
	@JoinTable(name="participator_activity", joinColumns={@JoinColumn(name="participator", referencedColumnName="id")}, inverseJoinColumns={@JoinColumn(name="activity", referencedColumnName="id")}) 
	public Set<Activity> getParticipatedActivities() {
		return participatedActivities;
	}
	public void setParticipatedActivities(Set<Activity> participatedActivities) {
		this.participatedActivities = participatedActivities;
	}
	
	
}
