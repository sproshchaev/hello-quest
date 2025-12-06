package com.javarush.quest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class GameServletTest {

    private GameServlet gameServlet;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private HttpSession session;

    @Mock
    private RequestDispatcher requestDispatcher;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        gameServlet = new GameServlet();

        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        when(request.getContextPath()).thenReturn("");
    }

    @Test
    public void testDoPost_AcceptChallenge_ShouldSetVictory()
            throws ServletException, IOException {
        // Given
        when(request.getParameter("answer")).thenReturn("accept");

        // When
        gameServlet.doPost(request, response);

        // Then
        verify(session).setAttribute("result", "Победа! Вы приняли вызов.");
        verify(response).sendRedirect(contains("/result.jsp"));
    }

    @Test
    public void testDoPost_DeclineChallenge_ShouldSetDefeat()
            throws ServletException, IOException {
        // Given
        when(request.getParameter("answer")).thenReturn("decline");

        // When
        gameServlet.doPost(request, response);

        // Then
        verify(session).setAttribute("result", "Поражение! Вы отказались.");
        verify(response).sendRedirect(contains("/result.jsp"));
    }

    @Test
    public void testDoPost_NoAnswer_ShouldForwardToQuestionWithMessage()
            throws ServletException, IOException {
        // Given
        when(request.getParameter("answer")).thenReturn(null);

        // When
        gameServlet.doPost(request, response);

        // Then
        verify(request).setAttribute("message", "Выберите вариант!");
        verify(request).getRequestDispatcher("/question.jsp");
        verify(requestDispatcher).forward(request, response);
    }

    @Test
    public void testDoPost_EmptyAnswer_ShouldForwardToQuestionWithMessage()
            throws ServletException, IOException {
        // Given
        when(request.getParameter("answer")).thenReturn("");

        // When
        gameServlet.doPost(request, response);

        // Then
        verify(request, never()).setAttribute("message", "Выберите вариант!");
        verify(request, never()).getRequestDispatcher("/question.jsp");
        verify(response).sendRedirect(contains("/result.jsp"));
    }
}