package com.Data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.Models.Audio;

public class DAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Audio> getAllAudio() {
		
		String sql = "SELECT * FROM mydb.sounds";
		List<Audio> audios = this.jdbcTemplate.query(sql, new BeanPropertyRowMapper(Audio.class));
		
		
		return audios;
	}
	
	//getAudioByID
	//postAudio
	//updateAudio
	//deleteAudio
}
