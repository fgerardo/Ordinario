package boot.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;


import org.springframework.stereotype.Service;

import boot.dao.TransportRepository;
import boot.model.Title;
import boot.model.Transport;


@Service
@Transactional
public class TransportService {
	private final TransportRepository transportRepository;
	
	public TransportService(TransportRepository transportRepository){
		super();
		this.transportRepository=transportRepository;
	}
	
	public List<Transport> findAll(){
		List<Transport> transports= new ArrayList<Transport>();
		for(Transport transport:transportRepository.findAll()){
			transports.add(transport)
;		}
		return transports;
	}

	public void save(Transport transport){
		transportRepository.save(transport);
	}
	public void delete(int idTransport){
		transportRepository.delete(idTransport);
	}
	public Transport findTransport(int idTransport){
		return transportRepository.findOne(idTransport);
	}
}
