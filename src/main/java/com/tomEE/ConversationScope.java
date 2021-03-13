package com.tomEE;

import jakarta.enterprise.context.Conversation;
import jakarta.enterprise.context.ConversationScoped;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serializable;

@WebServlet(name = "ConversationScope", value = "/conversationScope")
public class ConversationScope extends HttpServlet {

    @Inject
    ConversationBean conversationBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(conversationBean.i);
        conversationBean.i = 1;
        conversationBean.startConversation();
        System.out.println(conversationBean.i);
        System.out.println("middle conversation");
        conversationBean.i = 3;
        conversationBean.endConversation();
        System.out.println(conversationBean.i);
    }
}
@ConversationScoped
class ConversationBean implements Serializable {
        int i;
        @Inject
        Conversation conversation;
        public void startConversation() {
            System.out.println(i);
            System.out.println("startConversation");
            conversation.begin();
            i = 2;
        }

        public void endConversation() {
            System.out.println(i);
            System.out.println("endConversation");
            conversation.end();
        }
}


