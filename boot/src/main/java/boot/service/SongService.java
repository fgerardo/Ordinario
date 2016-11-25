package boot.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import boot.dao.SongRepository;
import boot.model.Song;

@Service
@Transactional
public class SongService {
	private final SongRepository songRepository;
	
	public SongService(SongRepository songRepository){
		super();
		this.songRepository=songRepository;
	}
	public List<Song> findAll(){
		List<Song> songs=new ArrayList<Song>();
		for(Song song:songRepository.findAll()){
			songs.add(song);
		}
		return songs;
		
	}
	
	public void save(Song song){
		songRepository.save(song);
	}
	public void delete(int id){
		songRepository.delete(id);
	}
	
	public Song findSong(int id){
		return songRepository.findOne(id);
	}

}
