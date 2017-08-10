package site.wmblog.common.web.springmvc.controller;

import site.wmblog.common.web.xuser.XUser;
import site.wmblog.common.web.xuser.XUserSession;

/**
 * Created by Fe on 15/6/26.
 */
public class BaseUserController extends BaseController {


    public void refreshXUser(XUser xUser) {
        XUserSession.getCurrent().setXUser(xUser);
    }
}
