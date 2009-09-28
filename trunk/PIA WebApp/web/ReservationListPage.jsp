<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : LabListingPage
    Created on : 23.09.2009., 23.06.50
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
                        <webuijsf:listbox required="true" selected="#{reservationSelectedBean.selected}" id="listbox1" items="#{reservationListGetBean.optionList}" style="font-size: 15pt" />
                        <br/>
                        <webuijsf:button actionExpression="#{reservationSelectedBean.action}" id="button1" text="Pogledaj rezervaciju" style = "font-size: 15pt"/><br/>
                    </webuijsf:form>
                    <webuijsf:form id="form3">
                        <webuijsf:button actionExpression="#{reservationPrepareBean.action}" id="button3" text="Kreiranje nove rezervacije" style = "font-size: 15pt"/><br/>
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
