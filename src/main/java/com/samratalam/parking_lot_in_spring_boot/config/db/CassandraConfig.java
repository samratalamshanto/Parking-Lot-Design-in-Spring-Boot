//package com.samratalam.parking_lot_in_spring_boot.config.db;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
//import org.springframework.data.cassandra.core.mapping.BasicCassandraMappingContext;
//import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
//
//@Configuration
//public class CassandraConfig extends AbstractCassandraConfiguration {
//    @Override
//    protected String getKeyspaceName() {
//        return "testKeySpace";
//    }
//
//    @Bean
//    public CassandraClusterFactoryBean cluster() {
//        CassandraC cluster =
//                new CassandraClusterFactoryBean();
//        cluster.setContactPoints("127.0.0.1");
//        cluster.setPort(9142);
//        return cluster;
//    }
//}
//
//
