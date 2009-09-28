<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : RegisterPage
    Created on : 24.09.2009., 13.02.22
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
                        <webuijsf:textField id="textField1" label="Korisnicko ime" required="true" text="#{registerBean.regData.username}" style="font-size: 15pt"/><br/>
                        <webuijsf:passwordField id="passwordField1" label="Lozinka" required="true" password="#{registerBean.regData.password}" style="font-size: 15pt"/><br/>
                        <webuijsf:textField id="textField2" label="Ime" required="true" text="#{registerBean.regData.name}" style="font-size: 15pt"/><br/>
                        <webuijsf:textField id="textField3" label="Prezime" required="true" text="#{registerBean.regData.lastname}" style="font-size: 15pt"/><br/>
                        <webuijsf:textField id="textField4" label="Email" required="true" text="#{registerBean.regData.email}" style="font-size: 15pt"/><br/>
                        <webuijsf:textField id="textField5" label="Funkcija na fakultetu" required="true" text="#{registerBean.regData.title}" style="font-size: 15pt"/><br/>
                        <br/>
                        <webuijsf:button id="button1" actionExpression="#{registerBean.action}" text="Registrujte se" style = "font-size: 15pt"/>
                    </webuijsf:form>
                    <webuijsf:form id="form2">
                            <webuijsf:button actionExpression="#{gotopage.back}" id="button2" text="Nazad" style = "font-size: 15pt"/>
                    </webuijsf:form>
                    </DIV>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
