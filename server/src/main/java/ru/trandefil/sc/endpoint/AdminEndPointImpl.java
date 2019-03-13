package ru.trandefil.sc.endpoint;

import ru.trandefil.sc.api.AdminService;
import ru.trandefil.sc.model.Role;
import ru.trandefil.sc.model.Session;
import ru.trandefil.sc.exception.SecurityAuthentificationException;
import ru.trandefil.sc.exception.SecurityAuthorizationException;
import ru.trandefil.sc.generated.AdminEndPoint;
import ru.trandefil.sc.util.SignatureUtil;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.jws.WebMethod;
import javax.jws.WebService;

@Singleton
//@WebService(endpointInterface = "ru.trandefil.tm.generated.AdminEndPoint")
public class AdminEndPointImpl implements AdminEndPoint {

    @Inject
    private AdminService adminService;

    @Override
    @WebMethod
    public void saveJson(Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            throw new SecurityAuthentificationException("security authentification exception.");
        }
        if (!session.getRole().equals(Role.ADMIN)) {
            System.out.println("not authorized  to do this command.");
            throw new SecurityAuthorizationException("not authorized for this operation.");
        }
        adminService.saveJson();
    }

    @Override
    @WebMethod
    public void loadJson(Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            throw new SecurityAuthentificationException("security authentification exception.");
        }
        if (!session.getRole().equals(Role.ADMIN)) {
            System.out.println("not authorized  to do this command.");
            throw new SecurityAuthorizationException("not authorized for this operation.");
        }
        adminService.loadJson();
    }

    @Override
    @WebMethod
    public void clearJson(Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            throw new SecurityAuthentificationException("security authentification exception.");
        }
        if (!session.getRole().equals(Role.ADMIN)) {
            System.out.println("not authorized  to do this command.");
            throw new SecurityAuthorizationException("not authorized for this operation.");
        }
        adminService.clearJson();
    }

}
