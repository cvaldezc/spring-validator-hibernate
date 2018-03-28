package io.cvaldezchavez.dao;

import java.util.List;

import io.cvaldezchavez.form.Subcriptor;

public interface SubcriptorDao {
	
	public Subcriptor saveSubcriptor(Subcriptor subcriptor);
	
	public List<Subcriptor> listSubcriptor();

}
