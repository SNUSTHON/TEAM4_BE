package com.example.team4_be.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@EntityListeners(AuditingEntityListener.class)
public class User extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name="relation")
	private String relation;

	@Column(name="birth")
	private LocalDate birth;

	@Column(name="memorial_date")
	private LocalDate memorialDate;

	@Column(name="profile_image")
	private String profileImage;

	@OneToMany(mappedBy = "user")
	private List<UserImage> userImages = new ArrayList<>();

	@OneToMany(mappedBy = "user")
	private List<Video> videos = new ArrayList<>();

	public User(String name, String relation, LocalDate birth, LocalDate memorialDate, String profileImage) {
		this.name = name;
		this.relation = relation;
		this.birth = birth;
		this.memorialDate = memorialDate;
		this.profileImage = profileImage;
	}
}
