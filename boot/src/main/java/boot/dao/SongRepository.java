package boot.dao;

import org.springframework.data.repository.CrudRepository;

import boot.model.Song;

public interface SongRepository extends CrudRepository<Song,Integer>{

}
