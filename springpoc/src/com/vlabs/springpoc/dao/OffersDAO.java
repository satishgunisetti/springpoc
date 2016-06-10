package com.vlabs.springpoc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

import com.vlabs.springpoc.beans.Offer;

@Repository("offersDao")
public class OffersDAO {

	private NamedParameterJdbcTemplate jdbc;

	
	public OffersDAO() {
		System.out.println("Loaded DAO..");
	}

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public List<Offer> getAllOffers() {
		return jdbc.query("select * from offers", new RowMapper<Offer>() {

			@Override
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {

				Offer offer = new Offer();
				offer.setId(rs.getInt("id"));
				offer.setName(rs.getString("name"));
				offer.setEmail(rs.getString("email"));
				offer.setText(rs.getString("text"));

				return offer;
			}

		});
	}

	public Offer getOffer(int id) {
		MapSqlParameterSource param = new MapSqlParameterSource("id", id);
		return jdbc.queryForObject("select * from offers where id = :id", param, new RowMapper<Offer>() {

			@Override
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {

				Offer offer = new Offer();
				offer.setId(rs.getInt("id"));
				offer.setName(rs.getString("name"));
				offer.setEmail(rs.getString("email"));
				offer.setText(rs.getString("text"));

				return offer;
			}

		});
	}
	
	public boolean delete(int id){
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id", id);
		return jdbc.update("delete from offers where id = :id", param) == 1;
	}
	
	public boolean create(Offer offer){
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
		return jdbc.update("insert into offers(name,email,text) values(:name,:email,:text)", params) == 1;
	}
	
	public boolean update(Offer offer){
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(offer);
		return jdbc.update("update offers set name = :name, email = :email, text = :text where id = :id", param) == 1;
	}
	
	public int[] create(List<Offer> offers){
		SqlParameterSource[] param = SqlParameterSourceUtils.createBatch(offers.toArray());
		
		return jdbc.batchUpdate("insert into offers(name,email,text) values(:name,:email,:text)", param);
	}

}
