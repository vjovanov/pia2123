<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : UserManagePage
    Created on : 26.09.2009., 03.07.54
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
                        <h:outputText value="Korisnicko ime: #{manageUser.user.username}" style="font-size: 20pt"/><br/>
                        <h:outputText value="Ime: #{manageUser.user.name}" style="font-size: 20pt"/><br/>
                        <h:outputText value="Prezime: #{manageUser.user.lastname}" style="font-size: 20pt"/><br/>
                        <h:outputText value="Email: #{manageUser.user.email}" style="font-size: 20pt"/><br/>
                        <h:outputText value="Funkcija na fakultetu: #{manageUser.user.title}" style="font-size: 20pt"/><br/>
                        <webuijsf:button actionExpression="#{manageUser.deleteUser}" id="button1" text="Brisanje korisnika" style = "font-size: 15pt"/><br/>
                        <webuijsf:button actionExpression="#{manageUser.userReservations}" id="button2" text="Pregled rezervacija korisnika" style = "font-size: 15pt"/><br/>
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
