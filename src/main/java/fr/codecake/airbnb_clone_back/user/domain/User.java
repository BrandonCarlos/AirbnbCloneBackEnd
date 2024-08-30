package fr.codecake.airbnb_clone_back.user.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "airbnb_user")
public class User extends AbstractAuditingEntity<Long>{



}
