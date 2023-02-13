package com.codegym.repository;

import com.codegym.model.Song;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SongRepository implements ISongRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Song> findAll() {
        List<Song> songList = new ArrayList<>();
        TypedQuery<Song> query = entityManager.createQuery("from Song", Song.class);
        songList = query.getResultList();
        return songList;
    }

    @Override
    public Song findById(int id) {
        return entityManager.find(Song.class, id);
    }

    @Transactional
    @Override
    public void save(Song song) {
        entityManager.persist(song);
    }

    @Transactional
    @Override
    public void update(int id, Song song) {
        Song songEdit = findById(song.getId());
        songEdit.setName(song.getName());
        songEdit.setMusician(song.getMusician());
        songEdit.setGenre(song.getGenre());
        songEdit.setPath(song.getPath());
        entityManager.merge(songEdit);
    }

    @Override
    public void remove(int id) {
        Song songDelete = findById(id);
        entityManager.remove(songDelete);
    }
}
