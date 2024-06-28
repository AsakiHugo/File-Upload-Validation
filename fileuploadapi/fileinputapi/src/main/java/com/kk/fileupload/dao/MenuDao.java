package com.kk.fileupload.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kk.fileupload.entity.Menu;

public interface MenuDao extends JpaRepository<Menu, String> {

}
