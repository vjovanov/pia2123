<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : UserLoggedPage
    Created on : 24.09.2009., 00.47.23
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
                        
                        <h:outputText value="Dobro dosli #{userBean.name}" style="font-size: 20pt"/>
                        <br/><br/><br/>
                        <webuijsf:button actionExpression="#{labListingBean.action}" id="button1" text="Pregled i rezervacija laboratorija" style = "font-size: 15pt"/><br/>
                        <webuijsf:button actionExpression="#{reservationListGetBean.action}" id="button2" text="Pregled rezervacija" style = "font-size: 15pt"/>
                    </webuijsf:form>
                    
                    </DIV>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
