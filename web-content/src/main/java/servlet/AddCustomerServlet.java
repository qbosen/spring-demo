package servlet;

import dao.CustomerDao;
import dao.CustomerDaoImpl;
import org.apache.commons.beanutils.BeanUtils;
import po.Customer;
import service.CustomerService;
import service.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author qiubaisen
 * @date 2018/9/16
 */
public class AddCustomerServlet extends HttpServlet {
    private CustomerService service;

    public AddCustomerServlet() {
        super();
        CustomerDao dao = new CustomerDaoImpl();
        service = new CustomerServiceImpl(dao);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        // 接收参数
        Map<String, String[]> parameterMap = req.getParameterMap();

        // 封装数据
        Customer customer = new Customer();
        try {
            BeanUtils.populate(customer, parameterMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 第二步：调用业务方法
        String message = service.addCustomer(customer);

        // 响应
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().print(message);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}

