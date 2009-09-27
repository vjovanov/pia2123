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
                        <h:outputText id="outputText1" value="Dobro dosli #{user.name}" style = "font-size: 20pt"/><br/>
                        <webuijsf:button actionExpression="#{manageUser.userRequestsList}" id="button1" text="Pregled zahteva za registraciju" style = "font-size: 15pt"/><br/>
                        <webuijsf:button actionExpression="#{manageUser.userListing}" id="button2" text="Pregled korisnika" style = "font-size: 15pt"/><br/>
                        <webuijsf:button actionExpression="#{gotopage.addUser}" id="button3" text="Dodavanje korisnika" style = "font-size: 15pt"/><br/>
                        <webuijsf:button actionExpression="#{manageUser.labListing}" id="button4" text="Lista laboratorija" style = "font-size: 15pt"/><br/>
                        <webuijsf:button actionExpression="#{gotopage.notWorkingDays}" id="button5" text="Definisanje neradnih dana" style = "font-size: 15pt"/><br/>
                    </webuijsf:form>
                    </DIV>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>

</jsp:root>
