package com.SelfProject.StockInventorysales.Repository;

import com.SelfProject.StockInventorysales.Entity.Users;
import com.SelfProject.StockInventorysales.Util.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findByEmail(String email);
}
