package com.example.demo;

import com.example.demo.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try {
//            Album album = new Album();
//            album.setName("앨범");
//            album.setPrice(5000);
//            album.setArtist("artist");
//            em.persist(album);
            User user = new User();
            user.setName("bert");
            em.persist(user);

            em.flush();
            em.clear();

//            Album findAlbum = em.find(Album.class, album.getId());
//            System.out.println(">>>> findAlbum = " + findAlbum);
//
//            Item findItem = em.find(Item.class, album.getId());
//            System.out.println(">>>> findItem = " + findItem);

            tx.commit();
        } catch(Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}