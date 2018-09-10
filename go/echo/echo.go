package main

import (
	"croz.us/hellok8/echo"
	"golang.org/x/net/context"
	"google.golang.org/grpc"
	"log"
	"time"
)

const address = "localhost:8080"

func main() {
	// Connect
	conn, err := grpc.Dial(address, grpc.WithInsecure())
	if err != nil {
		log.Fatalf("Error dialing: %v", err)
	}
	defer conn.Close()

	// Initialize Request
	c := echo.NewEchoServiceClient(conn)
	ctx, cancel := context.WithTimeout(context.Background(), time.Second)
	defer cancel()
	req := echo.EchoRequest{Request: "foo", Count: 3}

	// Send Request
	log.Printf("Sending request: %v", req)
	r, err := c.Echo(ctx, &req)
	if err != nil {
		log.Fatalf("error calling echo: %v", err)
	}
	log.Printf("Received response: %s", r.Response)
}
