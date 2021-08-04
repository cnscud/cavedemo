#!/bin/sh


zk list /xpower/cache


zk create /xpower/cache/redis.test redis.test.conf
zk create /xpower/cache/redis.cluster.test redis.cluster.test.conf

zk set /xpower/cache/redis.test redis.test.conf
zk set /xpower/cache/redis.cluster.test redis.cluster.test.conf
