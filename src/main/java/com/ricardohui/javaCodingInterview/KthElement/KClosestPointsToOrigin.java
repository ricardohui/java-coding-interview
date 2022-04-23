package com.ricardohui.javaCodingInterview.KthElement;

import java.util.*;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int distFromOrigin() {
        // ignoring sqrt
        return (x * x) + (y * y);
    }
}

class KClosestPointsToOrigin {

    public static List<Point> findClosestPoints(Point[] points, int k) {

        Queue<Point> maxDistanceInMinimum = new PriorityQueue<>((p1, p2)->p2.distFromOrigin()- p1.distFromOrigin());

        for (int i = 0; i < k; i++) {
            maxDistanceInMinimum.offer(points[i]);
        }

        int i = k;
        while (i < points.length) {
            if (points[i].distFromOrigin() < maxDistanceInMinimum.peek().distFromOrigin()){
                maxDistanceInMinimum.poll();
                maxDistanceInMinimum.offer(points[i]);
            }

            i++;
        }
        return new ArrayList<>(maxDistanceInMinimum);
    }

    public static void main(String[] args) {
        Point[] points = new Point[] { new Point(1, 3), new Point(3, 4), new Point(2, -1) };
        List<Point> result = KClosestPointsToOrigin.findClosestPoints(points, 2);
        System.out.print("Here are the k points closest the origin: ");
        for (Point p : result)
            System.out.print("[" + p.x + " , " + p.y + "] ");
    }
}