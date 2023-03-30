package com.masai.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.CategoryException;
import com.masai.Model.Category;
import com.masai.Repository.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepo catRepo;
	
	
	@Override
	public Category addCategory(Category cat) throws CategoryException {
		
		if(cat==null) throw new CategoryException("Please enter valid details ");
		
		return catRepo.save(cat);
		
	}

	@Override
	public Category updateCategory(Category cat) throws CategoryException {
		
		catRepo.findById(cat.getCatid()).orElseThrow(()->new CategoryException("Category is not registered"));
		
		return catRepo.save(cat);
	}

	@Override
	public String removeCategory(Integer catID) throws CategoryException {
		
		Category cat = catRepo.findById(catID).orElseThrow(() -> new CategoryException("Category does not exist"));
		
		catRepo.delete(cat);
		
		return "Category with name "+cat.getCategoryName()+ " is deleted successfully";
		
	}

	@Override
	public Category viewCategory(Integer catID) throws CategoryException {
		
		return catRepo.findById(catID).orElseThrow(() -> new CategoryException("Category with id "+catID+" does not exist."));

	}

	@Override
	public List<Category> viewAllCategory() throws CategoryException {
		
		List<Category> list = catRepo.findAll();
		

		if (list.isEmpty())
			throw new CategoryException("No user exist in database");

		return list;
	}

}
