<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : LoginPage
    Created on : 23.09.2009., 20.09.50
    Author     : Administrator
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head id="head1">
                    <webuijsf:link id="link1" url="/resources/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <DIV ALIGN="Center">
                        <webuijsf:form id="form1">
                            <webuijsf:textField id="textfield1" label="Unesi korisnicko ime:" required="true" style="font-size: 15pt" text="#{loginBean.username}"/>
                            <br/>
                            <webuijsf:passwordField id="passwordField1" label="Unesi lozinku:" password="#{loginBean.password}" required="true" style="font-size: 15pt"/>
                            <br/>
                            <br/>
                            
                            <webuijsf:button actionExpression="#{loginBean.action}" id="button1" style="font-size: 15pt" text="Uloguj se"/>
                            <br/>
                        </webuijsf:form>
                        <webuijsf:form id="form2">
                            <webuijsf:button actionExpression="#{gotopage.registration}" id="button2" style="font-size: 15pt" text="Registracija novih korisnika"/>
                            <br/>
                        </webuijsf:form>
                    </DIV>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
