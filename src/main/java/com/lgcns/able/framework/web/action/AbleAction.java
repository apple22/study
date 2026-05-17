package com.lgcns.able.framework.web.action;

import javax.servlet.http.HttpServletRequest;

/**
 * ❌ 현대카드 프로젝트 투입 후 완전히 제거해야 할 Able 1.0의 유산입니다.
 */
public abstract class AbleAction {
    public abstract void executeAction(HttpServletRequest request) throws Exception;
}
