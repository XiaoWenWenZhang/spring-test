package com.thoughtworks.rslist.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rsEvent")
public class RsEventDto implements Comparable<RsEventDto>{
  @Id @GeneratedValue private int id;
  private String eventName;
  private String keyword;
  private int voteNum;
  @ManyToOne private UserDto user;
  @Builder.Default
  private int tradeRank = Integer.MAX_VALUE;

  @Override
  public int compareTo(RsEventDto o) {
    if(this.tradeRank < o.tradeRank) return -1;
    else if(this.tradeRank > o.tradeRank) return 1;
    else {
      if (this.voteNum > o.voteNum) return -1;
      else return 1;
    }
  }
}
