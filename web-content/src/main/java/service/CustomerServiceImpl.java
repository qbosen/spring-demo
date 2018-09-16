package service;

import dao.CustomerDao;
import po.Customer;

/**
 * @author qiubaisen
 * @date 2018/9/16
 */
public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao;

    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public String addCustomer(Customer customer) {
        Integer line = customerDao.insert(customer);
        if (line != null && line > 0) {
            return "添加成功！";
        } else {
            return "添加失败！";
        }
    }
}
