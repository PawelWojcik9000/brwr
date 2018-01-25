package pl.browarmistrz.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.browarmistrz.entities.Malt;
import pl.browarmistrz.repositories.MaltRepository;

public class MaltConverter implements Converter<String, Malt>{

	@Autowired
	private MaltRepository maltRepository;
	
	@Override
	public Malt convert(String source) {
		Malt malt = maltRepository.findOne(Integer.parseInt(source));
		return malt;
	}
	
}
