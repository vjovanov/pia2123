<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : UserRequestViewPage
    Created on : 25.09.2009., 22.47.22
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
                    <DIV ALIGN="center">
                    <webuijsf:form id="form1">
                       <h:outputText value="Korisnicki zahtev" style="font-size: 30pt"/><br/>
                       <h:outputText value="Korisnicko ime: #{manageUser.userRequest.username}" style="font-size: 20pt"/><br/>
                       <h:outputText value="Ime: #{manageUser.userRequest.name}" style="font-size: 20pt"/><br/>
                       <h:outputText value="Prezime: #{manageUser.userRequest.lastname}" style="font-size: 20pt"/><br/>
                       <h:outputText value="Email: #{manageUser.userRequest.email}" style="font-size: 20pt"/><br/>
                       <h:outputText value="Funkcija na fakultetu: #{manageUser.userRequest.title}" style="font-size: 20pt"/><br/>
                       <h:outputText value="Datum podnosenja zahteva: #{manageUser.userRequest.requestDate}" style="font-size: 20pt"/><br/>
                       <webuijsf:button actionExpression="#{manageUser.acceptRequest}" id="button1" text="Prihvati zahtev za registraciju" style = "font-size: 15pt"/><br/>
                    </webuijsf:form>
                    <webuijsf:form id="form2">
                        <webuijsf:button actionExpression="#{manageUser.denyRequest}" id="button1" text="Odbi zahtev za registraciju" style = "font-size: 15pt"/>
                    </webuijsf:form>
                    <webuijsf:form id="form3">
                        <webuijsf:button actionExpression="#{gotopage.back}" id="button1" text="Nazad" style = "font-size: 15pt"/>
                    </webuijsf:form>
                    </DIV>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
