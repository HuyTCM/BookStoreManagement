package com.huytcm.bookstore.dao;

import java.util.List;

public interface IBaseDao <Model, Id> {
	public Model getById(Id id);

    public void insert(Model model);

    public void update(Model model);

    public void delete(Model model);

    public List<Model> getAll();
}
