package vn.iotstar.controllers.user;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import vn.iotstar.entity.Users_21146474;
import vn.iotstar.services.IUserService_21146474;
import vn.iotstar.services.Impl.UserService_21146474;

@MultipartConfig(fileSizeThreshold = 1024 * 1024,

maxFileSize = 1024 * 1024 * 5,

maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet(urlPatterns = {"admin/user","admin/user/add","admin/user/insert","admin/user/edit","admin/user/update",
							"admin/user/delete","admin/user/search"})
public class UserController_21146474 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public IUserService_21146474 userService = new UserService_21146474();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		String url = req.getRequestURI();

		if (url.contains("/user")) {
			List<Users_21146474> list = userService.findAll();
			req.setAttribute("listcate", list);
			req.getRequestDispatcher("/views/admin/list.jsp").forward(req, resp);
		}
		else if (url.contains("/admin/category/edit")) {
			int id = Integer.parseInt(req.getParameter("id"));
			Users_21146474 user = userService.findById(id);
			req.setAttribute("u", user);
			req.getRequestDispatcher("/views/admin/category-edit.jsp").forward(req, resp);
		}
		else if (url.contains("/admin/category/add")) {
			req.getRequestDispatcher("/views/admin/category-add.jsp").forward(req, resp);
		}
		else if (url.contains("/admin/category/delete")) {
			String id = req.getParameter("id");
			try {
				userService.delete(Integer.parseInt(id));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resp.sendRedirect(req.getContextPath() + "/admin/categories");
		}
	}
	@SuppressWarnings("unused")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		String url = req.getRequestURI();
		if (url.contains("/admin/category/insert")) {
			String email = req.getParameter("email");
		    String fullname = req.getParameter("fullname");
		    int phone = Integer.parseInt(req.getParameter("phone"));
		    String psw = req.getParameter("psw");
		    LocalDateTime signupDate = LocalDateTime.now(); // Lấy ngày hiện tại làm ngày đăng ký
		    Boolean isAdmin = Boolean.parseBoolean(req.getParameter("is_admin"));
		    
		    Users_21146474 user = new Users_21146474();
		    user.setEmail(email);
		    user.setFullname(fullname);
		    user.setPhone(phone);
		    user.setPsw(psw);
		    user.setSignup_date(signupDate);
		    user.setLast_login(null); // Đặt giá trị mặc định cho Last_login, có thể cập nhật sau
		    user.setIs_admin(isAdmin);

		    // Thêm dữ liệu vào cơ sở dữ liệu
		    userService.insert(user);

		    // Điều hướng về danh sách các danh mục
		    resp.sendRedirect(req.getContextPath() + "/admin/categories");
		}
		else if(url.contains("/admin/category/update")) {
			int id = Integer.parseInt(req.getParameter("id")); // ID cần để tìm kiếm đối tượng hiện tại
			Users_21146474 entity = userService.findById(id); // Tìm kiếm đối tượng theo ID
			if (entity == null) {
			    resp.sendRedirect(req.getContextPath() + "/error"); // Điều hướng đến trang lỗi nếu không tìm thấy
			    return;
			}

			// Lấy các giá trị từ request để cập nhật đối tượng
			String email = req.getParameter("email");
			String fullname = req.getParameter("fullname");
			int phone = Integer.parseInt(req.getParameter("phone"));
			String psw = req.getParameter("psw");
			LocalDateTime lastLogin = LocalDateTime.now(); // Cập nhật thời gian đăng nhập cuối

			// Cập nhật các giá trị thuộc tính cho đối tượng đã tìm thấy
			entity.setEmail(email);
			entity.setFullname(fullname);
			entity.setPhone(phone);
			entity.setPsw(psw);
			entity.setLast_login(lastLogin);

			// Cập nhật trạng thái admin nếu có
			Boolean isAdmin = Boolean.parseBoolean(req.getParameter("is_admin"));
			entity.setIs_admin(isAdmin);

			// Lưu đối tượng sau khi cập nhật
			userService.UpdateByUser(psw, fullname, phone);

			// Điều hướng sau khi cập nhật thành công
			resp.sendRedirect(req.getContextPath() + "/success");


		}
	}

}
