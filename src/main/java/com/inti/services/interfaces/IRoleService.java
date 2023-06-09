package com.inti.services.interfaces;

import java.util.List;

import com.inti.entities.Role;

public interface IRoleService {
	List<Role> findAll();

	Role findOne(Long id);

	Role save(Role role);

	void delete(Long id);
}
