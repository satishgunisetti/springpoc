package com.vlabs.springpoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vlabs.springpoc.beans.Offer;
import com.vlabs.springpoc.dao.OffersDAO;

@Service("offersService")
public class OffersServiceImpl implements OffersService {
	@Autowired
	private OffersDAO offerDao;
	
	public OffersServiceImpl() {
		System.out.println("Service loaded..");
	}
	
	@Override
	public List<Offer> getAllOffers() {
		return offerDao.getAllOffers();
	}

	@Override
	public Offer getOffer(int id) {
		// TODO Auto-generated method stub
		return offerDao.getOffer(id);
	}

	@Override
	public boolean create(Offer offer) {
		// TODO Auto-generated method stub
		return offerDao.create(offer);
	}

	@Override
	public boolean update(Offer offer) {
		// TODO Auto-generated method stub
		return offerDao.update(offer);
	}

	@Override
	public boolean delete(Offer offer) {
		// TODO Auto-generated method stub
		return offerDao.update(offer);
	}

	@Override
	public int[] create(List<Offer> offers) {
		// TODO Auto-generated method stub
		return offerDao.create(offers);
	}

}
