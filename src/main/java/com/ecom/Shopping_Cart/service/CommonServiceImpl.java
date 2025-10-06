package com.ecom.Shopping_Cart.service;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class CommonServiceImpl implements CommonService {
    @Override
//    for remove msg from UI
    public void removeSessionMessage() {
        HttpServletRequest request = ((ServletRequestAttributes)(RequestContextHolder.getRequestAttributes())).getRequest();
        HttpSession session = request.getSession();
        request.removeAttribute("successMsg");
        request.removeAttribute("errorMsg");

    }
}
