package org.leanpoker.player;

class APlayer {

//  @Test
//  void all_in_right_now() throws JsonProcessingException {
//    JsonNode jsonNode = Player.OBJECT_MAPPER.readTree(example);
//
//    assertEquals(1000, Player.betRequest(jsonNode));
//  }


  String example = """
      {
        "tournament_id": "66559491eb1286000231be58",
        "game_id": "6655a77208adbe0002a9d374",
        "round": 4,
        "players": [
          {
            "name": "Rusty Ladies",
            "stack": 984,
            "status": "active",
            "bet": 4,
            "time_used": 1139935,
            "version": "0.1",
            "id": 0
          },
          {
            "name": "Peanuts",
            "stack": 0,
            "status": "out",
            "bet": 0,
            "time_used": 286224,
            "version": "0.0.6 - logging",
            "id": 1
          },
          {
            "name": "Poker Prestidigitators",
            "stack": 2010,
            "status": "active",
            "bet": 2,
            "hole_cards": [
              {
                "rank": "2",
                "suit": "diamonds"
              },
              {
                "rank": "5",
                "suit": "hearts"
              }
            ],
            "time_used": 569937,
            "version": "1.3",
            "id": 2
          }
        ],
        "small_blind": 2,
        "big_blind": 4,
        "orbits": 1,
        "dealer": 0,
        "community_cards": [],
        "current_buy_in": 4,
        "pot": 6,
        "in_action": 2,
        "minimum_raise": 2,
        "bet_index": 3
      }""";

  String anotherExample = """
      {"tournament_id":"66559491eb1286000231be58","game_id":"6655f238a172ca0002930d24","round":25,"players":[{"name":"Rusty Ladies","stack":953,"status":"active","bet":10,"time_used":14228351,"version":"Ultimate chan killer ","id":0},{"name":"Peanuts","stack":0,"status":"out","bet":0,"time_used":283520,"version":"0.0.23 - hello Lars :)","id":1},{"name":"Poker Prestidigitators","stack":2027,"status":"active","bet":10,"hole_cards":[{"rank":"7","suit":"clubs"},{"rank":"K","suit":"clubs"}],"time_used":13073076,"version":"3.4","id":2}],"small_blind":5,"big_blind":10,"orbits":8,"dealer":0,"community_cards":[{"rank":"2","suit":"hearts"},{"rank":"Q","suit":"spades"},{"rank":"A","suit":"spades"},{"rank":"4","suit":"hearts"}],"current_buy_in":10,"pot":20,"in_action":2,"minimum_raise":10,"bet_index":0}"""

      String moreExamples = """
          {"tournament_id":"66559491eb1286000231be58","game_id":"6655f210a172ca0002930d21","round":47,"players":[{"name":"Rusty Ladies","stack":946,"status":"active","bet":961,"time_used":20218293,"version":"Ultimate chan killer ","id":0},{"name":"Peanuts","stack":0,"status":"out","bet":0,"time_used":4006092,"version":"0.0.24 - hello again Lars :)","id":1},{"name":"Poker Prestidigitators","stack":1063,"status":"active","bet":30,"hole_cards":[{"rank":"9","suit":"hearts"},{"rank":"5","suit":"spades"}],"time_used":18721933,"version":"3.4","id":2}],"small_blind":15,"big_blind":30,"orbits":15,"dealer":2,"community_cards":[],"current_buy_in":961,"pot":991,"in_action":2,"minimum_raise":931,"bet_index":5}"""

          String lastOne = """
              {"tournament_id":"66559491eb1286000231be58","game_id":"6655f2f1a172ca0002930d31","round":20,"players":[{"name":"Rusty Ladies","stack":1009,"status":"active","bet":10,"time_used":9081560,"version":"Ultimate chan killer ","id":0},{"name":"Peanuts","stack":0,"status":"out","bet":0,"time_used":577343,"version":"0.0.24 - hello again Lars :)","id":1},{"name":"Poker Prestidigitators","stack":1976,"status":"active","bet":5,"hole_cards":[{"rank":"A","suit":"diamonds"},{"rank":"3","suit":"hearts"}],"time_used":8514637,"version":"3.4","id":2}],"small_blind":5,"big_blind":10,"orbits":6,"dealer":0,"community_cards":[],"current_buy_in":10,"pot":15,"in_action":2,"minimum_raise":5,"bet_index":3}"""
}
