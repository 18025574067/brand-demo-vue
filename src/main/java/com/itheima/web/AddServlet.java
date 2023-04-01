package com.itheima.web;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    private BrandService service = new BrandService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 接收数据, request.getParameter不能接收json的数据
//        String brandName = req.getParameter("brandName");
//        System.out.println(brandName);
        // 获取请求体数据
        BufferedReader br = req.getReader();
        String params = br.readLine();

        // 将JSON字符串转为java对象
        Brand brand = JSON.parseObject(params, Brand.class);
//        System.out.println(brand);

        // 调用service方法添加
        service.add(brand);

        // 3. 响应成功标识
        resp.getWriter().write("success");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
