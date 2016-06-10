package com.vlabs.springpoc.service;

import java.util.List;

import com.vlabs.springpoc.beans.Offer;

public interface OffersService {
	public List<Offer> getAllOffers();
	public Offer getOffer(int id);
	public boolean create(Offer offer);
	public boolean update(Offer offer);
	public boolean delete(Offer offer);
	public int[] create(List<Offer> offers);
}
