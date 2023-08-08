package com.skb.graphql.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ContentSmd(String result,
                         String reason,
                         String IF,
                         String like,
                         String dislike,
                         String updateDate,
                         String like_total,
                         String dislike_total,
                         String updateDate_total) {

}