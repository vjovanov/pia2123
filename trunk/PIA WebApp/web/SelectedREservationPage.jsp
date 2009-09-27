<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : SelectedREservationPage
    Created on : 27.09.2009., 10.25.07
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
                        <h:outputText id="text1" value="Sala: #{user.reservation.sala}" style="font-size: 20pt"/><br/>
                        <h:outputText id="text2" value="Namena rezervacije: #{user.reservation.namena}" style="font-size: 20pt"/><br/>
                        <h:outputText id="text3" value="Rezervisana dana #{user.reservation.datum} sa pocetkom u #{user.reservation.pocevOd} i trajanjem od #{user.reservation.trajanje}" style="font-size: 20pt"/><br/>
                        <webuijsf:button actionExpression="#{user.reservationDelete}" id="button1" text="Brisanje rezervacije" style = "font-size: 15pt"/>
                    </webuijsf:form>
                    </DIV>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
