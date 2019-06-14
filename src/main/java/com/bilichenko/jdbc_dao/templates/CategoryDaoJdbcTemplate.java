package com.bilichenko.jdbc_dao.templates;

import java.sql.ResultSet;
import java.sql.Types;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import com.bilichenko.model.Category;

//@Repository
public class CategoryDaoJdbcTemplate {

//	@Autowired
	private JdbcTemplate template;

	public Optional<List<Category>> getAll() {
		String sql = "SELECT ID, NAME, DESCRIPTION FROM CATEGORIES;";
		List<Category> categories = template.query(sql, (ResultSet rs, int n) -> { 
			Category category = new Category();
			category.setId(rs.getLong("id"));
			category.setName(rs.getString("name"));
			category.setDescription(rs.getString("description"));
			return category;
			});

		return Optional.ofNullable(categories);
	}

	public Optional<Category> create(Category category) {
		String sql = "INSERT INTO CATEGORIES VALUES (?, ?, ?);";
		Category category1 = template.execute(sql, (PreparedStatementCallback<Category>) psc -> {
			psc.setNull(1, Types.BIGINT);
			psc.setString(2, category.getName());
			psc.setString(3, category.getDescription());
			psc.execute();
			ResultSet keys = psc.getGeneratedKeys();
			if (keys.next()) {
				category.setId(keys.getLong(1));
				return category;
			} else {
				return null;
			}
		});

		return Optional.ofNullable(category1);
	}

	public Optional<Category> getById(Long id) {
		String sql = "SELECT ID, NAME, DESCRIPTION FROM CATEGORIES WHERE ID=?";
		Category category = template.execute(sql, (PreparedStatementCallback<Category>) ps -> {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Category category1 = new Category();
				category1.setId(rs.getLong("id"));
				category1.setName(rs.getString("name"));
				category1.setDescription(rs.getString("description"));
				return category1;
			} else {
				return null;
			}
		});
		return Optional.ofNullable(category);
	}

	public Optional<Category> update(Category category) {
		String sql = "UPDATE CATEGORIES SET NAME=?, DESCRIPTION=? WHERE ID=?";
		template.update(sql, pss -> {
			pss.setString(1, category.getName());
			pss.setString(2, category.getDescription());
			pss.setLong(3, category.getId());
			pss.executeUpdate();
		});
		return Optional.of(category);
	}
}