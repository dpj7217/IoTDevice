package com.Data;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.Models.Audio;

public class DAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public List<Audio> getAllAudio() {
		
		String sql = "SELECT * FROM mydb.sounds";
		List<Audio> audios = this.
				jdbcTemplate.
				query(
						sql,
						new BeanPropertyRowMapper(
								Audio.class
								)
						)
				;
		
		
		return audios;
	}
	
	
	public void postAudio(Audio a) {
		Map<String, Object> parameters = a.getParametersMap();
		
		SimpleJdbcInsert sji = new SimpleJdbcInsert(this.jdbcTemplate.getDataSource());
		
		sji.execute(a.getParametersMap());
	}
	
	//getAudioByID
	//updateAudio
	//deleteAudio
}
