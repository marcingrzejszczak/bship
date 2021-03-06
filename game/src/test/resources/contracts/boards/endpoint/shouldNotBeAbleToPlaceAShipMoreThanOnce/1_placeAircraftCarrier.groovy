package contracts.boards.endpoint.shouldNotBeAbleToPlaceAShipMoreThanOnce

import org.springframework.cloud.contract.spec.Contract

Contract.make {
  request {
    method 'PUT'
    urlPath '/boards/1'
    headers {
      contentType(applicationJson())
    }
    body([
        type : 'AIRCRAFT_CARRIER',
        start: [
            x: 0,
            y: 0
        ],
        end  : [
            x: 0,
            y: 4
        ]
    ])
  }
  response {
    status 200
    headers {
      contentType(applicationJson())
    }
    body([id   : 1,
          ships: [[
                      type : 'AIRCRAFT_CARRIER',
                      start: [
                          x: 0,
                          y: 0
                      ],
                      end  : [
                          x: 0,
                          y: 4
                      ],
                      sunk : false,
                      id   : 1
                  ]],
          moves: []
    ])
  }
}

