package com.example.model;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "client")
public class Client {
        @Id
        public Long id;

        public String name;

        @CollectionTable(name = "zid_ids",
                joinColumns = @JoinColumn(name = "id_client", referencedColumnName = "id"))
        @Column(name = "id")
        @ElementCollection(fetch = FetchType.EAGER)
        @Fetch(FetchMode.SUBSELECT)
        public Set<Long> zidIds = new HashSet<>();

        @OneToOne(orphanRemoval = true)
        @JoinColumn(name = "id_service_account", nullable = false)
        public ServiceAccount serviceAccount;

}
