package com.springbootdemo.springboot.controller;

import com.springbootdemo.springboot.dao.DepartmentDao;
import com.springbootdemo.springboot.dao.EmployeeDao;
import com.springbootdemo.springboot.entities.Department;
import com.springbootdemo.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {
    //查询所有员工返回列表
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;
    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        //放在请求域中进行传值
        //model是前后端进行传值的，emps是传入先端的标志
        model.addAttribute("emps", employees);
        //thymeleaf默认会拼串
        return "emp/list";
    }
    //来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);

        return "emp/add";

    }

    //springMvc自动将请求参数和入参对象的属性进行一一绑定
    //要求请求参数的名字和JavaBean入参的对象里面的属性一一对应
    @PostMapping("/emp")
    public  String addEmp(Employee employee){
        //点击确定之后要返回到员工列表
        //redirect表示重定向到一个地址  /代表当前项目路径
        //forward代表转发一个地址
        //坑：日期格式必须为yyyy/mm/dd，要不然就会出错
        //保存员工信息
        employeeDao.save(employee);
//        System.out.println("保存的员工信息："+employee);
        return  "redirect:/emps";

    }
    //回到修改页面，看到员工
    @GetMapping("/emp/{id}")
    public  String toAddEdit(@PathVariable("id")Integer id,Model model){
        //根据id获取当前员工的信息
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);

        /*
           根据id获取了员工的信息，将员工信息放进了emp中，在add页面中通过value值可以进行赋值
         */
         Collection<Department> departments = departmentDao.getDepartments();
         model.addAttribute("depts",departments);
        //add页面时修改添加二合一页面
        return "emp/add";

    }
    //员工修改
    @PutMapping("/emp")
    public String updateEmployee(Employee employee ) {
        System.out.println("修改员工信息："+employee);
        employeeDao.save(employee);
        return  "redirect:/emps";
    }
    //员工删除
    @DeleteMapping("/emp/{id}")
    public  String deleteEmp(@PathVariable("id")Integer id){

        employeeDao.delete(id);
        return  "redirect:/emps";

    }


}

