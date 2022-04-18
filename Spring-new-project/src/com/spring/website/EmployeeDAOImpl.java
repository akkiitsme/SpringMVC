package com.spring.website;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	private JdbcTemplate jdbcTemp;

	@Autowired
	public EmployeeDAOImpl(DataSource dataSource) {
		this.jdbcTemp = new JdbcTemplate(dataSource);
	}

	@Autowired
	EmployeeDAO employeeDAO;

	/* ------------For Common Bean------------- */
	@Override
	public List<EmployeeCommonBean> getUserList(int val) {
		String sql = "SELECT generic_info_id,generic_value FROM lu_generic_information WHERE generic_type='"+val+"'";
		List<EmployeeCommonBean> list = jdbcTemp.query(sql, new RowMapper<EmployeeCommonBean>() {
			@Override
			public EmployeeCommonBean mapRow(ResultSet rs, int arg1) throws SQLException {
				EmployeeCommonBean bean = new EmployeeCommonBean();
				bean.setId(rs.getInt("generic_info_id"));
				bean.setVal(rs.getString("generic_value"));
				return bean;
			}
		});
		return list;
	}

	/* -------------For parsing Dob in simple way--------------- */
	@Override
	public String getUserDOBSplited(String dob) {
		String sql = "SELECT generic_value FROM lu_generic_information WHERE generic_info_id='" + dob + "'";
		String ddmmyy = jdbcTemp.queryForObject(sql, String.class);
		return ddmmyy;
	}
	/* ------------For Insert Employee data---------------- */

	@Override
	public void insertData(Employee employee) {
		String sql = "";
		try {
			// String tempDob =
			// employee.getDay()+"-"+employee.getMonth()+"-"+employee.getYear();
			// Employee dobBean = employeeDAO.getUserDOB(tempDob);

			String dd = employeeDAO.getUserDOBSplited(employee.getDay());
			String mm = employeeDAO.getUserDOBSplited(employee.getMonth());
			String yy = employeeDAO.getUserDOBSplited(employee.getYear());
			String newDob = dd + "/" + mm + "/" + yy;
			Date getDob = new SimpleDateFormat("dd/MM/yyyy").parse(newDob);

			sql = "INSERT INTO trx_user_information(first_name,last_name,gender,dob,emp_status,org_name,edu,status,created_on) VALUES(?,?,?,?,?,?,?,1,now())";
			jdbcTemp.update(sql, employee.getFirstName(), employee.getLastName(), employee.getGender(), getDob,
					employee.getEmpStatus(), employee.getOrgName(), employee.getEdu());
		} catch (Exception e) {
			System.out.println("exception for insertData in EmpolyeeDaoImpl : " + e);
			e.printStackTrace();
		}

	}

	/* -------------For Get Employee Data By ID--------------- */

	public Employee getEmpById(int id) {
		String sql = "SELECT * FROM trx_user_information WHERE user_info_id='" + id + "'";
		return jdbcTemp.query(sql, new ResultSetExtractor<Employee>() {

			@Override
			public Employee extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					Employee bean = new Employee();
					bean.setUserInfoId(rs.getInt("user_info_id"));
					bean.setFirstName(rs.getString("first_name"));
					bean.setLastName(rs.getString("last_name"));
					bean.setGender(rs.getString("gender"));
					bean.setEmpStatus(rs.getString("emp_status"));
					bean.setOrgName(rs.getString("org_name"));
					bean.setEdu(rs.getString("edu"));
					// Splitting Date of birth
					String newDob = rs.getString("dob");
					String newDate[] = newDob.split("-");
					String year = newDate[0];
					String month = newDate[1];
					String day = newDate[2];
					// Setting dob to day month and year
					bean.setDay(getDate(day, "1"));
					bean.setMonth(getDate(month, "2"));
					bean.setYear(getDate(year, "3"));

					System.out.println("Day:" + day + " month:" + month + " year:" + year);
					return bean;
				}
				return null;
			}
		});
	}

	/* -------------For Set Date in Edit Details page--------------- */
	@Override
	public String getDate(String val, String type) {
		String sql = "SELECT generic_info_id FROM lu_generic_information WHERE generic_value='" + val
				+ "' AND generic_type ='" + type + "'";
		return jdbcTemp.queryForObject(sql, String.class);
	}

	/* -------------For Update Employee Data--------------- */
	@Override
	public void updateData(Employee emp) {
		String sql = "";
		try {
			String dd = employeeDAO.getUserDOBSplited(emp.getDay());
			String mm = employeeDAO.getUserDOBSplited(emp.getMonth());
			String yy = employeeDAO.getUserDOBSplited(emp.getYear());
			String newDob = dd + "/" + mm + "/" + yy;
			Date getDob = new SimpleDateFormat("dd/MM/yyyy").parse(newDob);

			sql = "UPDATE trx_user_information SET first_name=?,last_name=?,gender=?,dob=?,emp_status=?,org_name=?,edu=? WHERE user_info_id=?";
			jdbcTemp.update(sql, emp.getFirstName(), emp.getLastName(), emp.getGender(), getDob, emp.getEmpStatus(),
					emp.getOrgName(), emp.getEdu(), emp.getUserInfoId());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/* -------------For Parsing Dob in new Way--------------- */
//	@Override
//	public Employee getUserDOB(String dob) {
//		//10-11-1987 1-3-78
//		//split function  
//		//list0,list2,list3 1,3,78
//		//sql query lu_generic_information where generic_info_id in(1,3,78)
//		//id,val 
//		//if(id=1){a  val of 1 : 10}
//		//if(id=2){b  val of 3 : 11 }
//		//if(id=1){c val of 78 : 1987 }
//		// a/b/c
//		//new Stringdateformatter(dd/MM/yyyy).parse(a/b/c)
//		return null;
//	}

}
