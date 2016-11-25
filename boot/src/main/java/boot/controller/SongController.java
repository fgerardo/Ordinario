package boot.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.model.Song;
import boot.service.SongService;



@Controller
public class SongController {
	@Autowired
	private SongService songService;
	@GetMapping("song")
	public String home(HttpServletRequest request){
		request.setAttribute("mode","MODE_HOME");
		return "song";
	}
	//*Apartir de aqui nuevos metodos*/
	@GetMapping("/all-songs")
	public String allSongs(HttpServletRequest request){
		request.setAttribute("songs",songService.findAll());
		request.setAttribute("mode","MODE_SONGS");
		return "song";
	}
	
	@GetMapping("/new-song")
	public String newSong(HttpServletRequest request){
		request.setAttribute("mode","MODE_NEW");
		return "song";
	}
	@PostMapping("/save-song")
	public String saveSong(@ModelAttribute Song song,BindingResult bindingResult, HttpServletRequest request){
		SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd");
		Date creationDate=new Date();
		
		try{
			creationDate=format.parse(request.getParameter("creationDate"));
		}catch (ParseException e){
			e.printStackTrace();
		}
		song.setCreationDate(creationDate);
		songService.save(song);
		request.setAttribute("songs",songService.findAll());
		request.setAttribute("mode","MODE_SONGS");
		return "song";
	}
	
	
	@GetMapping("/update-song")
	public String updateSong(@RequestParam int id,HttpServletRequest request){
		request.setAttribute("song",songService.findSong(id));
		request.setAttribute("mode","MODE_UPDATE");
		return "song";
	}
	@GetMapping("/delete-song")
	public String deleteSong(@RequestParam int id,HttpServletRequest request){
		songService.delete(id);
		request.setAttribute("songs",songService.findAll());
		request.setAttribute("mode","MODE_SONGS");
		return "song";
	}
	
	
}
