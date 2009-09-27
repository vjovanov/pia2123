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
                    <webuijsf:form id="form1">
                        <DIV ALIGN="Center">
                        <webuijsf:listbox selected="#{labmanager.selected}" id="listbox1" items="#{labmanager.lista}" style="font-size: 15pt" />
                        <br/>
                        <webuijsf:button actionExpression="#{labmanager.laboratorySelected}" id="button1" text="Pregled izabrane laboratorije" style = "font-size: 15pt"/>
                        </DIV>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
