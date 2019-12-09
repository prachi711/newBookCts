package com.cts.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cts.Entity.User;




@Repository("UserDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	  DataSource dataSource;
	  @Autowired
	  JdbcTemplate jdbcTemplate;
	 
	  
	  
	  
	  
	 




	@Override
	public void registerUser(User user) {
		String sql = "insert into users values(?,?,?,?,?)";
	    jdbcTemplate.update(sql, new Object[] { user.getName(), user.getUserName(), user.getPassword(), 
	     user.getDob(), user.getAddress() });
		
	}




	@Override
	public User loginUser(User user) {
		String sql = "select * from users where username='" + user.getUserName() + "' and password='" + user.getPassword()
	    + "'";
	    List<User> users = jdbcTemplate.query(sql, new UserMapper());
	    
	    return users.size() > 0 ? users.get(0) : null;
	}
	  }
	  





	class UserMapper implements RowMapper<User> {
	  public User mapRow(ResultSet rs, int arg1) throws SQLException {
	    User user = new User();
	    user.setName(rs.getString("Name"));
	    user.setUserName(rs.getString("Username"));
	    user.setPassword(rs.getString("Password"));
	    user.setDob(rs.getString("DOB"));
	    user.setAddress(rs.getString("Address"));
	   
	    return user;
	  }
}






	








